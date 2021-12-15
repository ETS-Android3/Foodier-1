package edu.uw.foodier
// This file is for the homePage created by Lauren Ng
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.facebook.drawee.backends.pipeline.Fresco
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeableMethod
import edu.uw.foodier.databinding.HomePageBinding
import edu.uw.foodier.viewmodels.homePageViewModel
import kotlinx.android.synthetic.main.home_page.*
import kotlinx.coroutines.launch
import android.os.AsyncTask
import androidx.core.content.ContentProviderCompat.requireContext
import java.lang.ref.WeakReference


class homePage : Fragment(), CardStackListener {
    private var _binding: HomePageBinding? = null
    private val binding get() = _binding!!
    private val homePageModel : homePageViewModel by activityViewModels()

    private val adapter = FoodListAdapter()
    private lateinit var layoutManager: CardStackLayoutManager
    private lateinit var dataSet : List<FoodItem>

    private var foodItemDb: FoodItemDatabase ?= null
    private lateinit var dao: FoodItemDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the DAO..
        dao = FoodItemDatabase.getInstance(requireContext()).foodItemDao()
    }

//    private fun insertFood(food: FoodItem) {
//        lifecycleScope.launch {
//            dao.insert(food)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HomePageBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        creatCardView();

    }

    private fun creatCardView() {
        Fresco.initialize(context)


        dataSet = homePageModel.getFoodItems()
        adapter.updateData(dataSet);

        layoutManager = CardStackLayoutManager(context, this).apply {
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setOverlayInterpolator(LinearInterpolator())
        }

        stack_view.layoutManager = layoutManager
        stack_view.adapter = adapter
        stack_view.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    private var swipedDirection = "right"
    override fun onCardDisappeared(view: View?, position: Int) {
        if (swipedDirection == "right") {
            Log.d("HOMEPAGE", "The number is $position and values include ${dataSet[position].food_name}")
            // PASS TO ROOM HERE!!!!
            val likedFoodObject = dataSet[position]

            InsertTask(this@homePage, likedFoodObject).execute()
        }
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
        if (direction == Direction.Left) {
            // dislike
            swipedDirection = "left"
            // don't do anything
        } else if (direction == Direction.Right){
            // like
            swipedDirection = "right"
            // add to database
            //foodItemDatabase.
        }
    }

    override fun onCardCanceled() {

    }

    override fun onCardAppeared(view: View?, position: Int) {

    }

    override fun onCardRewound() {

    }

    private class InsertTask internal constructor(context: homePage?, food: FoodItem) :
        AsyncTask<Void?, Void?, Boolean>() {
        private var activityReference: WeakReference<homePage>
        private lateinit var food: FoodItem

        fun InsertTask(context: homePage, food: FoodItem) {
            activityReference = WeakReference(context)
            this.food = food
        }

        // doInBackground methods runs on a worker thread
        protected override fun doInBackground(vararg objs: Void?): Boolean? {
            activityReference.get()?.dao?.insert(food)
            return true
        }

//        // onPostExecute runs on main thread
//        override fun onPostExecute(bool: Boolean) {
//            if (bool) {
//                activityReference.get().setResult(note, 1)
//            }
//        }

        // only retain a weak reference to the activity
        init {
            activityReference = WeakReference(context)
            this.food = food
        }
    }
}
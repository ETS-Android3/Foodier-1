package edu.uw.foodier
// This file is for the homePage created by Lauren Ng
// and describes the high level functionality of the home page
// here, we create the card view and implement the main functionalities
// also creating the navigation to the bookmark activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
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
    private lateinit var adapter : FoodListAdapter
    private lateinit var layoutManager: CardStackLayoutManager
    private lateinit var dataSet : List<FoodItem>
    private var swipedDirection = "right"

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

    // when the view is created, I will be binding the current home page to the home activity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    // when the view is created, we will add the card view logic and populate the page to have
    // card to swipe, like tinder
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = FoodListAdapter(homePageModel)
        createCardView();
    }

    // passes data to the adapter to display the cards, creates the layout for how the card
    // will be displayed and creates the scaffolding for actions and animations
    private fun createCardView() {
        dataSet = homePageModel.getFoodItems()
        adapter.updateData(dataSet)

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

        // when the food item updates with distance, update the adapter's dataset
        homePageModel.observeFoodItemUpdate().observe(viewLifecycleOwner, Observer {
            adapter.updateDistance(it)
        })
    }

    // when the card is disappeared, we will either add to the room database, if the user swiped
    // right or do nothing if they swiped left
    override fun onCardDisappeared(view: View?, position: Int) {
        if (swipedDirection == "right") {
            Log.d("HOMEPAGE", "The number is $position and values include ${dataSet[position].food_name}")
            // PASS TO ROOM HERE!!!!
            val likedFoodObject = dataSet[position]

            InsertTask(this@homePage, likedFoodObject).execute()
        }
    }

    // identifies which direction the card was swiped
    override fun onCardSwiped(direction: Direction?) {
        if (direction == Direction.Left) {  // dislike
            swipedDirection = "left"
        } else if (direction == Direction.Right){  // like
            swipedDirection = "right"
        }
    }

    // the following functions are helper functions for the card view. They aren't necessary for
    // the functionality in the current project. But the app doesn't run when they aren't implemented
    override fun onCardDragging(direction: Direction?, ratio: Float) {
//        TODO("Not yet implemented")
    }

    override fun onCardRewound() {
//        TODO("Not yet implemented")
    }

    override fun onCardCanceled() {
//        TODO("Not yet implemented")
    }

    override fun onCardAppeared(view: View?, position: Int) {
//        TODO("Not yet implemented")

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
            //activityReference.get()?.dao?.deleteAllFoods()
            if (activityReference.get()?.dao?.getAllFoodItems()?.contains(food) == true) {
               return false
            } else {
                //activityReference.get()?.dao?.deleteAllFoods()
                activityReference.get()?.dao?.insert(food)
                return true
            }
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
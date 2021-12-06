package edu.uw.foodier

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.facebook.drawee.backends.pipeline.Fresco
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeableMethod
import edu.uw.foodier.databinding.HomePageBinding
import kotlinx.android.synthetic.main.home_page.*

class homePage : Fragment(), CardStackListener {
    private var _binding: HomePageBinding? = null
    private val binding get() = _binding!!

    private val adapter = ProfileAdapter()
    private lateinit var layoutManager: CardStackLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HomePageBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Fresco.initialize(context)

        val foodItemObj = FoodItemType()
        foodItemObj.itemName = "Japchae"
        foodItemObj.food_image = "https://s3-media0.fl.yelpcdn.com/bphoto/m6Xl1f5SL8ctmlHJYryHHg/o.jpg"
        foodItemObj.restaurant = "Korean Tofu House"
        foodItemObj.address = "4142 Brooklyn Ave NE Seattle, WA 98105"
        val bundle = bundleOf(Constants.HOME_PAGE_TO_DETAIL_PAGE_BUNDLE to foodItemObj)
        binding.homeButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_details, bundle)
        }

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
            Log.d("HOMEPAGE", "The number is $position")
        }
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
        if (direction == Direction.Left) {
            Log.d("SwIPED DIRECTION", "left")
            // dislike
            swipedDirection = "left"
            // don't do anything
        } else if (direction == Direction.Right){
            Log.d("SwIPED DIRECTION", "right")
            // like
            swipedDirection = "right"
            // add to database
        }
    }

    override fun onCardCanceled() {

    }

    override fun onCardAppeared(view: View?, position: Int) {

    }

    override fun onCardRewound() {

    }
}
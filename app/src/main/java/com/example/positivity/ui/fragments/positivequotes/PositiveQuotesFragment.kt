package com.example.positivity.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.positivity.R
import com.example.positivity.databinding.FragmentPositiveQuotesBinding
import com.example.positivity.ui.fragments.positivequotes.PositiveQuotesAdapter
import com.yuyakaido.android.cardstackview.*

class PositiveQuotes : Fragment() {

    private var _binding : FragmentPositiveQuotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var manager : CardStackLayoutManager
    private lateinit var settings : SwipeAnimationSetting
    private lateinit var mPositiveQuotesAdapter : PositiveQuotesAdapter
    private var mProgress : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPositiveQuotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        manager = CardStackLayoutManager(requireContext())
        mPositiveQuotesAdapter = PositiveQuotesAdapter(getQuotes(), mProgress)
        binding.sBar.max = getQuotes().size

        initialiseCardStack()

        settings = SwipeAnimationSetting.Builder()
            .setDirection(Direction.Left)
            .setDuration(Duration.Normal.duration)
            .setInterpolator(AccelerateInterpolator())
            .build()

        binding.btnNext.setOnClickListener {
            mProgress++
            mPositiveQuotesAdapter.updatePosition(mProgress)
            mPositiveQuotesAdapter.notifyDataSetChanged()
            manager.setSwipeAnimationSetting(settings)
            binding.cardStackView.swipe()
            binding.sBar.progress = mProgress
            if(binding.sBar.progress == binding.sBar.max){
                findNavController().navigate(PositiveQuotesDirections.actionPositiveToEndingFragment2())
            }
        }

        binding.btnPrev.setOnClickListener {
            if(mProgress != 0){
                mProgress--
                mPositiveQuotesAdapter.updatePosition(mProgress)
                mPositiveQuotesAdapter.notifyDataSetChanged()
                manager.setSwipeAnimationSetting(settings)
                binding.cardStackView.swipe()
                binding.sBar.progress = mProgress
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initialiseCardStack() {
        manager.setStackFrom(StackFrom.Top)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(12.0f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(false)
        manager.setCanScrollVertical(false)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        binding.cardStackView.layoutManager = manager
        binding.cardStackView.adapter = mPositiveQuotesAdapter
        binding.cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    private fun getQuotes() : ArrayList<String>{
        val quotesList : ArrayList<String> = ArrayList()

        quotesList.add("Miracles happen to those who believe in them.")
        quotesList.add("One small positive thought can change your whole day.")
        quotesList.add("If you are positive, you’ll see opportunities instead of obstacles.\n" +
                "\n")
        quotesList.add("Accentuate the positive, Eliminate the Negative, latch onto the affirmative.")
        quotesList.add("Believe that life is worth living and your belief will help create the fact.")
        quotesList.add("Inspiration comes from within yourself. One has to be positive. When you’re positive, good things happen.")
        quotesList.add("Don’t focus on negative things; focus on the positive, and you will flourish.")
        quotesList.add("The less you respond to negative people, the more positive your life will become.")
        quotesList.add("Live life to the fullest and focus on\n" +
                "the positive.")
        quotesList.add("Be so happy that, when other people look at you, they become happy too.")
        quotesList.add("A truly happy person is one who can enjoy the scenery while on\n" +
                "a detour.")
        quotesList.add("The happiness of your life depends upon the quality of\n" +
                "your thoughts.")
        quotesList.add("The good life is a process, not a state of being. It is a direction, not a destination")
        quotesList.add("Happiness is the only thing that multiplies when you share it.")
        quotesList.add("When we are open to new possibilities, we find them. Be open and skeptical\n" +
                "of everything.")
        quotesList.add("Success is the sum of small efforts repeated day in and day out.")
        quotesList.add("If you want light to come into your life, you need to stand where it is shining.")
        quotesList.add("Wherever you go, no matter what the weather, always bring your own sunshine.")
        quotesList.add("Let your unique awesomeness and positive energy inspire confidence in others.")
        quotesList.add("The difference between ordinary and extraordinary is that little extra.")
        quotesList.add("Hard work keeps the wrinkles out of the mind and spirit.")
        quotesList.add("The more you praise and celebrate your life, the more there is in life to celebrate.")
        quotesList.add("Every day may not be good... but there’s something good in every day.")
        quotesList.add("The way I see it, if you want the rainbow, you gotta put up with\n" +
                "the rain.”")
        quotesList.add("The struggle you’re in today is developing the strength you\n" +
                "need tomorrow.")
        quotesList.add("It’s not whether you get knocked down, it’s whether you get up.")
        quotesList.add("The sun himself is weak when he first rises, and gathers strength and courage as the day gets on.")
        quotesList.add("You are never too old to set another goal or dream a new dream.")
        quotesList.add("Happiness is an attitude. We either make ourselves miserable, or happy and strong. The amount of work is\n" +
                "the same.")
        quotesList.add("You are never too old to set another goal or dream a new dream.")
        quotesList.add("Happiness is an attitude. We either make ourselves miserable, or happy and strong. The amount of work is\n" +
                "the same.")
        quotesList.add("If opportunity doesn’t knock, build a door.")
        quotesList.add("It makes a big difference in your life when you\n" +
                "stay positive.")
        quotesList.add("Optimism is a happiness magnet. If you stay positive good things and good people will be drawn to you.")
        quotesList.add("Virtually nothing is impossible in this world if you just put your mind to it and maintain a\n" +
                "positive attitude.")
        quotesList.add("Winning is fun, but those moments that you can touch someone’s life in a very positive way\n" +
                "are better.")
        quotesList.add("Positive anything is better than\n" +
                "negative nothing.")
        quotesList.add("“When you are enthusiastic about what you do, you feel this positive energy. It’s very simple.")
        quotesList.add("The only time you fail is when you fall down and stay down.")
        quotesList.add("In every day, there are 1,440 minutes. That means we have 1,440 daily opportunities to make a\n" +
                "positive impact.")
        quotesList.add("Positive thinking will let you do everything better than negative thinking will.")
        quotesList.add("Once you replace negative thoughts with positive ones, you’ll start having positive results.")
        quotesList.add("Keep your face to the sunshine and you cannot see a shadow.")
        quotesList.add("It always seems impossible until it\n" +
                "is done.")
        quotesList.add("You’re braver than you believe, and stronger than you seem, and smarter than you think.")
        quotesList.add("Winning doesn’t always mean being first. Winning means you’re doing better than you’ve\n" +
                "done before.")
        quotesList.add("No one is perfect - that’s why pencils have erasers.")
        quotesList.add("You always pass failure on the way\n" +
                "to success.")
        quotesList.add("You’re off to great places, today is your day. Your mountain is waiting, so get on\n" +
                "your way.")

        return quotesList
    }

}
package com.kmshack.example.fragmenttransitions

import android.os.Bundle
import androidx.transition.ChangeBounds
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.doOnPreDraw
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*


class GridFragment : androidx.fragment.app.Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var gridCount: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = ChangeBounds()

        if (arguments != null) {
            gridCount = arguments!!.getInt(ARG_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_grid, container, false)
        recyclerView = v.findViewById(R.id.recyclerview)
        return v
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        postponeEnterTransition()

        recyclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(activity!!.applicationContext, gridCount)
        recyclerView.adapter = Adapter()

        recyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

    companion object {

        private val ARG_COUNT = "count"

        fun newInstance(count: Int): GridFragment {
            val fragment = GridFragment()
            val args = Bundle()
            args.putInt(ARG_COUNT, count)
            fragment.arguments = args
            return fragment
        }
    }

    class Adapter : RecyclerView.Adapter<Adapter.GridViewHolder>() {

        private val urls = listOf(
                "https://image.bugsm.co.kr/album/images/500/201531/20153146.jpg",
                "https://image.bugsm.co.kr/album/images/500/6118/611813.jpg",
                "https://image.bugsm.co.kr/album/images/500/7194/719455.jpg",
                "https://image.bugsm.co.kr/album/images/500/201542/20154211.jpg",
                "https://image.bugsm.co.kr/album/images/500/201428/20142850.jpg",
                "https://image.bugsm.co.kr/album/images/500/201520/20152077.jpg",
                "https://image.bugsm.co.kr/album/images/500/201429/20142919.jpg",
                "https://image.bugsm.co.kr/album/images/500/201504/20150488.jpg",
                "https://image.bugsm.co.kr/album/images/500/201441/20144113.jpg",
                "https://image.bugsm.co.kr/album/images/500/7211/721172.jpg",
                "https://image.bugsm.co.kr/album/images/500/201267/20126756.jpg",
                "https://image.bugsm.co.kr/album/images/500/201504/20150488.jpg",
                "https://image.bugsm.co.kr/album/images/500/201531/20153146.jpg",
                "https://image.bugsm.co.kr/album/images/500/7194/719455.jpg",
                "https://image.bugsm.co.kr/album/images/500/201531/20153146.jpg",
                "https://image.bugsm.co.kr/album/images/500/6118/611813.jpg",
                "https://image.bugsm.co.kr/album/images/500/7194/719455.jpg",
                "https://image.bugsm.co.kr/album/images/500/201542/20154211.jpg",
                "https://image.bugsm.co.kr/album/images/500/201430/20143029.jpg",
                "https://image.bugsm.co.kr/album/images/500/7205/720576.jpg",
                "https://image.bugsm.co.kr/album/images/500/201482/20148250.jpg",
                "https://image.bugsm.co.kr/album/images/500/201437/20143753.jpg",
                "https://image.bugsm.co.kr/album/images/500/201542/20154211.jpg",
                "https://image.bugsm.co.kr/album/images/500/201516/20151686.jpg",
                "https://image.bugsm.co.kr/album/images/500/7183/718354.jpg",
                "https://image.bugsm.co.kr/album/images/500/201360/20136062.jpg",
                "https://image.bugsm.co.kr/album/images/500/201428/20142850.jpg",
                "https://image.bugsm.co.kr/album/images/500/201463/20146368.jpg",
                "https://image.bugsm.co.kr/album/images/500/201429/20142919.jpg",
                "https://image.bugsm.co.kr/album/images/500/201146/20114619.jpg",
                "https://image.bugsm.co.kr/album/images/500/6118/611813.jpg",
                "https://image.bugsm.co.kr/album/images/500/201267/20126756.jpg",
                "https://image.bugsm.co.kr/album/images/500/201504/20150488.jpg",
                "https://image.bugsm.co.kr/album/images/500/201531/20153146.jpg",
                "https://image.bugsm.co.kr/album/images/500/7194/719455.jpg",
                "https://image.bugsm.co.kr/album/images/500/201531/20153146.jpg",
                "https://image.bugsm.co.kr/album/images/500/6118/611813.jpg",
                "https://image.bugsm.co.kr/album/images/500/7194/719455.jpg",
                "https://image.bugsm.co.kr/album/images/500/201542/20154211.jpg",
                "https://image.bugsm.co.kr/album/images/500/201428/20142850.jpg",
                "https://image.bugsm.co.kr/album/images/500/201520/20152077.jpg",
                "https://image.bugsm.co.kr/album/images/500/201429/20142919.jpg",
                "https://image.bugsm.co.kr/album/images/500/201504/20150488.jpg",
                "https://image.bugsm.co.kr/album/images/500/201441/20144113.jpg",
                "https://image.bugsm.co.kr/album/images/500/7211/721172.jpg",
                "https://image.bugsm.co.kr/album/images/500/201430/20143029.jpg",
                "https://image.bugsm.co.kr/album/images/500/7205/720576.jpg",
                "https://image.bugsm.co.kr/album/images/500/201482/20148250.jpg",
                "https://image.bugsm.co.kr/album/images/500/201437/20143753.jpg",
                "https://image.bugsm.co.kr/album/images/500/201542/20154211.jpg",
                "https://image.bugsm.co.kr/album/images/500/201516/20151686.jpg",
                "https://image.bugsm.co.kr/album/images/500/7183/718354.jpg",
                "https://image.bugsm.co.kr/album/images/500/201432/20143285.jpg",
                "https://image.bugsm.co.kr/album/images/500/201482/20148250.jpg",
                "https://image.bugsm.co.kr/album/images/500/201437/20143753.jpg",
                "https://image.bugsm.co.kr/album/images/500/201542/20154211.jpg",
                "https://image.bugsm.co.kr/album/images/500/201516/20151686.jpg",
                "https://image.bugsm.co.kr/album/images/500/7183/718354.jpg",
                "https://image.bugsm.co.kr/album/images/500/201360/20136062.jpg",
                "https://image.bugsm.co.kr/album/images/500/201428/20142850.jpg",
                "https://image.bugsm.co.kr/album/images/500/201463/20146368.jpg",
                "https://image.bugsm.co.kr/album/images/500/201429/20142919.jpg",
                "https://image.bugsm.co.kr/album/images/500/201146/20114619.jpg",
                "https://image.bugsm.co.kr/album/images/500/6118/611813.jpg",
                "https://image.bugsm.co.kr/album/images/500/201267/20126756.jpg",
                "https://image.bugsm.co.kr/album/images/500/201504/20150488.jpg",
                "https://image.bugsm.co.kr/album/images/500/201531/20153146.jpg",
                "https://image.bugsm.co.kr/album/images/500/7194/719455.jpg",
                "https://image.bugsm.co.kr/album/images/500/201531/20153146.jpg",
                "https://image.bugsm.co.kr/album/images/500/6118/611813.jpg",
                "https://image.bugsm.co.kr/album/images/500/7194/719455.jpg")

        override fun onBindViewHolder(holder: GridViewHolder, position: Int) {

            val h: GridViewHolder = holder
            val imageView: ImageView = h.itemView.image
            imageView.transitionName = position.toString()

            Picasso.get().load(urls[position]).into(imageView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder = GridViewHolder(parent)

        override fun getItemCount(): Int {
            return urls.size
        }

        inner class GridViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))

    }


}// Required empty public constructor

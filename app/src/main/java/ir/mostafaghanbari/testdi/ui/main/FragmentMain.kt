package ir.mostafaghanbari.testdi.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import ir.mostafaghanbari.testdi.R
import ir.mostafaghanbari.testdi.model.Post
import ir.mostafaghanbari.testdi.presenter.PostPresenter
import ir.mostafaghanbari.testdi.presenter.PresenterCallBack
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

@AndroidEntryPoint
class FragmentMain : Fragment(), PresenterCallBack {

    @Inject
    lateinit var postPresenter: PostPresenter

    @ActivityContext
    @Inject
    lateinit var ctx: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        getPosts()

        btnCreatePost.setOnClickListener {
            createPostPage()
        }
    }

    private fun getPosts() {
        postPresenter.getPosts()
    }

    private fun setUpList(data: List<Post>) {
        RVMain.apply {
            adapter = AdapterMain(data)
            layoutManager = LinearLayoutManager(ctx)
        }
    }

    private fun createPostPage() {
        val action = FragmentMainDirections.actionAdd()
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun posts(data: List<Post>) {
        if (data.isEmpty()) {
            txtEmptyMessage.visibility = View.VISIBLE
            RVMain.visibility = View.GONE
        } else
            setUpList(data)
    }

}
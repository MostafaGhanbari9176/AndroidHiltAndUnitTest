package ir.mostafaghanbari.testdi.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import ir.mostafaghanbari.testdi.R
import ir.mostafaghanbari.testdi.presenter.PostPresenter
import ir.mostafaghanbari.testdi.presenter.PresenterCallBack
import kotlinx.android.synthetic.main.fragment_add_post.*
import javax.inject.Inject

@AndroidEntryPoint
class FragmentAdd : Fragment(), PresenterCallBack {

    @Inject
    lateinit var postPresenter: PostPresenter

    @Inject
    @ActivityContext
    lateinit var ctx: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        btnAdd.setOnClickListener {
            addPost()
        }
    }

    private fun addPost() {
        val title = edtPostTitle.text.toString()
        val message = edtPostMessage.text.toString()

        postPresenter.createPost(title, message)
    }

    override fun result(ok: Boolean, message: String) {
        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
        if (ok)
            showList()
    }

    private fun showList() {
        val action = FragmentAddDirections.actionList()
        Navigation.findNavController(requireView()).navigate(action)
    }

}
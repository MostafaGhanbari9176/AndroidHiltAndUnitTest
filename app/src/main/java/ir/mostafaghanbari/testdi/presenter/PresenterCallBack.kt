package ir.mostafaghanbari.testdi.presenter

import ir.mostafaghanbari.testdi.model.Post

/**
 * delivering presenter result and data to view
 */
interface PresenterCallBack {
    fun result(ok: Boolean, message: String){}

    fun posts(data:List<Post>){}
}
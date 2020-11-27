package com.mobile.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mobile.myapplication.posts.api.PostApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.POST


/**
 * A simple [Fragment] subclass as the third destination in the navigation.
 */
class ThirdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Log.i(tag:"ThirdFragment", msg:"onCreateView")
        val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addCallAdapterFactory(GsonConverterFactory.create(gson))
                .build()

        var postApi = retrofit.create(PostApi::class.java)
        var postCall = postApi.posts
        postCall.enqueue(object : Callback<Post>{
            override fun onFalure(call: Call<Post>, t: Throwable){
                Log.d(tag:"ThirdFragment", msg:"Error with API" + t.message)
            }
            override fun onResponse(call: Call<Post>, response: Response<Post>){
                var title = response.body()!!.title
                Log.d(tag:"ThirdFragment",title)
            }
        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
        }

    }
package com.example.mygithub.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygithub.databinding.ItemGithubUserBinding
import com.example.mygithub.domain.entity.SearchGithubUser
import com.example.mygithub.utils.loadUrl

class GithubUserAdapter(private var githubUsers: List<SearchGithubUser>) :
    RecyclerView.Adapter<GithubUserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGithubUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(githubUsers[position])
    }

    override fun getItemCount(): Int = githubUsers.size

    class ViewHolder(private val binding: ItemGithubUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(githubUser: SearchGithubUser) {
            binding.tvUsername.text = githubUser.username
            binding.ivGithubUser.loadUrl(githubUser.avatarUrl)
        }

    }

    fun refreshData(githubUsers: List<SearchGithubUser>){
        this.githubUsers = githubUsers
        notifyDataSetChanged()
    }
}

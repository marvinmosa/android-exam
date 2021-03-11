package com.prototype.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.prototype.R
import com.prototype.data.model.Person
import com.prototype.databinding.FragmentMainBinding
import com.prototype.ui.base.BaseFragment
import com.prototype.ui.main.adapter.MainAdapter
import com.prototype.ui.main.viewmodel.MainViewModel
import com.prototype.utils.Constant.EXTRA_DATA
import com.prototype.utils.Status
import org.koin.android.viewmodel.ext.android.viewModel


class MainFragment : BaseFragment(R.layout.fragment_main), MainAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter

    private var viewBinding: FragmentMainBinding? = null
    private val binding get() = viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        setupUi()
        setupObservers()
        return view
    }

    override fun setupUi() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = MainAdapter(arrayListOf(), this)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }

    override fun setupObservers() {
        mainViewModel.persons.observe(requireActivity(), {
            it?.let { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        result.data?.let { users -> retrieveList(users) }
                    }
                    Status.ERROR -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(person: List<Person>) {
        adapter.apply {
            addUsers(person)
            notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onItemClick(position: Int) {
        val user = adapter.getItem(position)
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(EXTRA_DATA, user)
        startActivity(intent)
    }
}
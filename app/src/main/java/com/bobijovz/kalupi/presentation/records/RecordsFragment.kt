package com.bobijovz.kalupi.presentation.records

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobijovz.kalupi.R
import com.bobijovz.kalupi.core.extension.viewBinding
import com.bobijovz.kalupi.databinding.FragmentActivitiesBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecordsFragment : Fragment(R.layout.fragment_activities) {

    private val viewModel by viewModel<RecordsViewModel>()
    private val binding by viewBinding(FragmentActivitiesBinding::bind)
    private lateinit var adapter: RecordsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RecordsAdapter()

        binding.rvActivityList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvActivityList.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.recordModel.collect {
                adapter.updateData(it)
            }
        }

        viewModel.loadActivities()
    }
}
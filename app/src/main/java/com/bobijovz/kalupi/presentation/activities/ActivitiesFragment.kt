package com.bobijovz.kalupi.presentation.activities

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

class ActivitiesFragment : Fragment(R.layout.fragment_activities) {

    private val viewModel by viewModel<ActivitiesViewModel>()
    private val binding by viewBinding(FragmentActivitiesBinding::bind)
    private lateinit var adapter: ActivitiesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ActivitiesAdapter()

        binding.rvActivityList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvActivityList.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.activityModel.collect {
                adapter.updateData(it)
            }
        }

        viewModel.loadActivities()
    }
}
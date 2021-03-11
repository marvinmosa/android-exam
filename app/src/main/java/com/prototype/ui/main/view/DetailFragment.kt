package com.prototype.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prototype.R
import com.prototype.data.model.Person
import com.prototype.databinding.FragmentDetailBinding
import com.prototype.ui.base.BaseFragment
import com.prototype.ui.main.viewmodel.DetailViewModel
import com.prototype.utils.AgeUtils
import com.prototype.utils.Constant.BUNDLE_DATA
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment(R.layout.fragment_detail) {

    companion object {
        fun newInstance(person: Person): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putSerializable(BUNDLE_DATA, person)
            fragment.arguments = bundle
        return fragment}
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private var viewBinding: FragmentDetailBinding? = null
    private val binding get() = viewBinding!!
    private lateinit var person: Person

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        val bundle: Bundle? = arguments
        person = bundle?.getSerializable(BUNDLE_DATA) as Person

        setupUi()
        setupObservers()
        return view
    }


    override fun setupUi() {
        binding.textName.text = "${person.firstName} ${person.lastName}"
        binding.textAge.text = AgeUtils.getAge(person.birthday)
        binding.textAddress.text = person.address
        binding.textEmail.text = person.email
        binding.textBirthday.text = AgeUtils.getShortBirthday(person.birthday)
        binding.textPhone.text = person.mobileNumber
        binding.textContactName.text = person.contactPerson
        binding.textContactPhone.text = person.contactPersonNumber

        binding.btnBack.setOnClickListener {
            activity?.finish()
        }
    }

    override fun setupObservers() {
        //do nothing
    }

}
package com.prototype.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prototype.R
import com.prototype.data.model.User
import com.prototype.databinding.FragmentDetailBinding
import com.prototype.ui.base.BaseFragment
import com.prototype.ui.main.viewmodel.DetailViewModel
import com.prototype.utils.AgeUtils
import com.prototype.utils.Constant.BUNDLE_DATA
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment(R.layout.fragment_detail) {

    companion object {
        fun newInstance(user: User): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putSerializable(BUNDLE_DATA, user)
            fragment.arguments = bundle
        return fragment}
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private var viewBinding: FragmentDetailBinding? = null
    private val binding get() = viewBinding!!
    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        val bundle: Bundle? = arguments
        user = bundle?.getSerializable(BUNDLE_DATA) as User

        setupUi()
        setupObservers()
        return view
    }


    override fun setupUi() {
        binding.textName.text = "${user.firstName} ${user.lastName}"
        binding.textAge.text = AgeUtils.getAge(user.birthday)
        binding.textAddress.text = user.address
        binding.textEmail.text = user.email
        binding.textBirthday.text = AgeUtils.getShortBirthday(user.birthday)
        binding.textPhone.text = user.mobileNumber
        binding.textContactName.text = user.contactPerson
        binding.textContactPhone.text = user.contactPersonNumber

        binding.btnBack.setOnClickListener {
            activity?.finish()
        }
    }

    override fun setupObservers() {
        //do nothing
    }

}
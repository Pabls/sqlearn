package ru.ar4i.sqlearn.presentation.quiz

import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.base.fragment.BaseVmFragment

class QuizFragment : BaseVmFragment<QuizViewModel>() {
    override val viewModel: Class<QuizViewModel>
        get() = QuizViewModel::class.java
    override val layoutId: Int
        get() = R.layout.fragment_quiz


    override fun initObservers() {
        TODO("Not yet implemented")
    }
}
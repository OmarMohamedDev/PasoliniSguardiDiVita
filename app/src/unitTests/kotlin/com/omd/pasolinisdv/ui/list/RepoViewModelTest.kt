package com.omd.pasolinisdv.ui.list

import com.omd.pasolinisdv.data.model.Owner
import com.omd.pasolinisdv.data.model.Repo
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RepoViewModelTest {


    lateinit var owner: Owner
    lateinit var section: Repo
    lateinit var viewModel: RepoViewModel

    @Before
    fun setUp() {
        owner = Owner("Author",
                "someURL")

        section = Repo("Name",
                "Author/Name",
                owner,
                "Some random section",
                50,
                100)

        viewModel = RepoViewModel(section)
        viewModel.bind()
    }

    @Test
    fun getName_returnsCorrectName() {
        Assert.assertEquals(viewModel.getName(), section.fullName)
    }

    @Test
    fun getDescription_returnsCorrectDescription() {
        Assert.assertEquals(viewModel.getDescription(), section.description)
    }

    @Test
    fun clicks_returnsNoClicks() {
        viewModel.clicks().test().assertNoValues()
    }

    @Test
    fun clicks_clicksOnce() {
        val observer = viewModel.clicks().test()

        viewModel.onClick()
        observer.assertValueCount(1)
    }
}
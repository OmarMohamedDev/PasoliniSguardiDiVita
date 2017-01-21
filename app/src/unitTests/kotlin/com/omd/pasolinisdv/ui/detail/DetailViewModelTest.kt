package com.omd.pasolinisdv.ui.detail

import com.omd.pasolinisdv.data.model.Owner
import com.omd.pasolinisdv.data.model.Repo
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    lateinit var owner: Owner
    lateinit var section: Repo
    lateinit var viewModel: DetailViewModel

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

        viewModel = DetailViewModel(section)
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
    fun getStars_returnsCorrectStarCount() {
        Assert.assertEquals(viewModel.getStars(), section.stars.toString())
    }

    @Test
    fun getForks_returnsCorrectForkCount() {
        Assert.assertEquals(viewModel.getForks(), section.forks.toString())
    }

    @Test
    fun getAvatarURL_returnsCorrectString() {
        Assert.assertEquals(viewModel.getAvatarURL(), section.owner.avatarUrl)
    }
}
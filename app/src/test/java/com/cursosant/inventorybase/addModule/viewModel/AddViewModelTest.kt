package com.cursosant.inventorybase.addModule.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosant.inventorybase.entities.Product
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddViewModelTest {

    //Component Architecture for Testing(Livedata etc...)
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addProductTest() {
        val viewModel = AddViewModel()
        val product = Product(116,
            "Xbox",
            20,
            "https://th.bing.com/th/id/OIP.potA47IX8Q4CcHrOq1gMjAHaHa?pid=ImgDet&rs=1https:" +
                    "//i.expansys.net/i/b/b328817-1.jpg",
            4.8,
        56)

        val observer = Observer<Boolean>{}

        try {
            viewModel.getResult().observeForever(observer)
            viewModel.addProduct(product)

            val result = viewModel.getResult().value

            assertThat(result, Matchers.`is`(true))
            assertThat(result, not(nullValue()))
        } finally {
            viewModel.getResult().removeObserver(observer)
        }

    }
}
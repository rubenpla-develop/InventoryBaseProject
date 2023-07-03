package com.cursosant.inventorybase.addModule.view

import android.app.AlertDialog
import android.app.Dialog
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosant.inventorybase.R
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddProductFragmentTest {

    @Test
    fun createDialog_notNullTest() {
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_InventoryBase)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment { fragment ->
            assertThat(fragment.dialog, `is`(notNullValue()))
        }
    }

    @Test
    fun cancelDialog_isNullTest() {
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_InventoryBase)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment { fragment ->
            (fragment.dialog as? AlertDialog)?.let {
                it.getButton(Dialog.BUTTON_NEGATIVE).performClick()
                assertThat(fragment.dialog, `is`(nullValue()))
            }
        }
    }
}
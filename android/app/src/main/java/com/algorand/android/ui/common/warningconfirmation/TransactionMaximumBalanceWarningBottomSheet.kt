/*
 * Copyright 2022 Pera Wallet, LDA
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.algorand.android.ui.common.warningconfirmation

import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.algorand.android.R
import com.algorand.android.utils.formatAsAlgoString
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionMaximumBalanceWarningBottomSheet : BaseMaximumBalanceWarningBottomSheet() {

    private val args: TransactionMaximumBalanceWarningBottomSheetArgs by navArgs()

    override fun setDescriptionText(descriptionTextView: TextView) {
        val formattedMinBalance = maximumBalanceWarningViewModel.getMinimumBalance(args.publicKey).formatAsAlgoString()
        descriptionTextView.text = getString(R.string.based_on_your_account, formattedMinBalance)
    }
}

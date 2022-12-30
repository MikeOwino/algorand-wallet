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

package com.algorand.android.modules.walletconnectfallbackbrowser.ui

import androidx.navigation.fragment.navArgs
import com.algorand.android.R
import com.algorand.android.models.AnnotatedString
import com.algorand.android.modules.walletconnectfallbackbrowser.ui.model.FallbackBrowserListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WalletConnectTransactionFallbackBrowserSelectionBottomSheet : BaseFallbackBrowserSelectionBottomSheet() {

    private val args: WalletConnectTransactionFallbackBrowserSelectionBottomSheetArgs by navArgs()

    override val peerMetaName: String
        get() = args.peerMetaName

    override val browserGroup: String
        get() = args.browserGroup

    override fun onNoBrowserFound() {
        nav(
            WalletConnectTransactionFallbackBrowserSelectionBottomSheetDirections
                .actionWalletConnectTransactionFallbackBrowserSelectionBottomSheetToSingleButtonBottomSheet(
                    titleAnnotatedString = AnnotatedString(R.string.your_transaction_is_being_processed),
                    drawableResId = R.drawable.ic_info,
                    drawableTintResId = R.color.info_tint_color,
                    descriptionAnnotatedString = AnnotatedString(
                        R.string.the_transaction_has_been_signed,
                        replacementList = listOf(
                            Pair(
                                "peer_name",
                                args.peerMetaName
                            )
                        )
                    )
                )
        )
    }

    @SuppressWarnings("MaxLineLength")
    override fun onSingleBrowserFound(fallbackBrowserListItem: FallbackBrowserListItem) {
        nav(
            WalletConnectTransactionFallbackBrowserSelectionBottomSheetDirections
                .actionWalletConnectTransactionFallbackBrowserSelectionBottomSheetToWalletConnectTransactionSingleBrowserBottomSheet(
                    browserItem = fallbackBrowserListItem,
                    peerMetaName = args.peerMetaName
                )
        )
    }
}

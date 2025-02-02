package com.bitlove.fetlife.view.conversation

import com.bitlove.fetlife.R
import com.bitlove.fetlife.databinding.FragmentCardListBinding
import com.bitlove.fetlife.model.dataobject.joined.ConversationWithMessages
import com.bitlove.fetlife.view.generic.CardListFragment
import com.bitlove.fetlife.viewmodel.conversation.ConversationListViewModel

class ConversationsFragment : CardListFragment<ConversationWithMessages, FragmentCardListBinding, ConversationListViewModel>() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_card_list
    }

    override fun getViewModelClass(): Class<ConversationListViewModel> {
        return ConversationListViewModel::class.java
    }
}
package com.card3333333.jetnoteapp.data

import com.card3333333.jetnoteapp.model.Note

class NoteDateSource{
    fun loadNotes(): List<Note>{
        return listOf(
            Note(title = "title1", description = "osidfnnsd sdfnmosin sdvckns"),
            Note(title = "title2", description = "osidfnnsd sdfnmosin sdvckns sfsdf"),
            Note(title = "title3", description = "osidfnnsd sdfnmosin sdvckns sdf sdfsdfsdf"),
            Note(title = "title4", description = "osidfnnsd sdfnmosin sdvckns sdf dsfcvx xvsdfsdf "),
            Note(title = "title5", description = "osidfnnsd sdfnmosin sdvckns sdf fsdf sdsdf vx"),
            Note(title = "title6", description = "osidfnnsd sdfnmosin sdvckns"),
            Note(title = "title7", description = "osidfnnsd sdfnmosin sdvckns"),
            Note(title = "title8", description = "osidfnnsd sdfnmosin sdvckns"),
            Note(title = "title9", description = "osidfnnsd sdfnmosin sdvckns"),
            Note(title = "title10", description = "osidfnnsd sdfnmosin sdvckns")
        )
    }
}
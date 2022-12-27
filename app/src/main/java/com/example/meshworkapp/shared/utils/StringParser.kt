package com.example.meshworkapp.shared.utils

import androidx.compose.ui.text.toUpperCase
import java.util.*

// 22_mca_2_a
class StringParser {
    fun extractCourseAndSectionGroup(inputString: String) : Pair<String,String>{
        var course : String = " "
        var group : String = " "

        var count = 0

        for (i in 0..inputString.length-1) {
            if (inputString[i] == '_') {
                count += 1
            }
            if(count == 2){
                group = inputString.substring(i, inputString.length)
                course = inputString.substring(0, i-1)
            }
        }
        return Pair(first = course, second = group)
    }

    fun extractCourseSectionAndGroup(inputString: String) : Pair<String,String> {

        var courseSection : String = " "
        var group : String = " "

        var count = 0

        for (i in 0..inputString.length-1) {
            if (inputString[i] == '_') {
                count += 1
            }
            if(count == 2){
                group = inputString.substring(i+2, inputString.length)
                courseSection = inputString.substring(0, i-1)
            }
        }



        return Pair(first = (courseSection.replace(oldValue = "_", newValue = "-").uppercase()), second = group.uppercase())
    }
}
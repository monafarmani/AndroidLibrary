package com.example.image_preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simon.xmaterialccp.component.MaterialCountryCodePicker
import com.simon.xmaterialccp.data.ccpDefaultColors
import com.simon.xmaterialccp.data.utils.getLibCountries

@Composable
fun CountryCodePickerItem(
    phoneCode: MutableState<String>,
    phoneNumber: MutableState<String>,
    defaultLang: MutableState<String>,
    isValidPhone: MutableState<Boolean>,
) {

    MaterialCountryCodePicker(
        pickedCountry = {
            phoneCode.value = it.countryPhoneCode
            defaultLang.value = it.countryCode
        },
        defaultCountry = getLibCountries().single { it.countryPhoneCode == phoneCode.value }.apply {
            defaultLang.value = this.countryCode
        },
        error = !isValidPhone.value,
        text = phoneNumber.value,
        onValueChange = { phoneNumber.value = it },

        searchFieldPlaceHolderTextStyle = MaterialTheme.typography.labelSmall.copy(
            fontWeight = FontWeight.Normal,
           // fontFamily = urbanistFontFamily,
            fontFamily = FontFamily.Cursive,
            fontSize = 14.sp,
            color = Color.White
        ),

        searchFieldTextStyle = MaterialTheme.typography.labelSmall.copy(
            fontWeight = FontWeight.Normal,
          //  fontFamily = urbanistFontFamily,
            fontFamily = FontFamily.Cursive,
            fontSize = 14.sp,
            color = Color.White
        ),

        phonenumbertextstyle =
        LocalTextStyle.current,

        countrytextstyle = MaterialTheme.typography.labelSmall.copy(
            fontWeight = FontWeight.Normal,
          //  fontFamily = urbanistFontFamily,
            fontFamily = FontFamily.Cursive,
            fontSize = 14.sp,
            color = Color.White
        ),

        countrycodetextstyle = MaterialTheme.typography.labelSmall.copy(
            fontWeight = FontWeight.Normal,
           // fontFamily = urbanistFontFamily,
            fontFamily = FontFamily.Cursive,
            fontSize = 14.sp,
            color = Color.White
        ),

        showErrorText = true,
        showCountryCodeInDIalog = true,
        showDropDownAfterFlag = true,

        textFieldShapeCornerRadiusInPercentage = 30,

        searchFieldShapeCornerRadiusInPercentage = 16,

        appbartitleStyle = MaterialTheme.typography.labelSmall.copy(
          //  fontFamily = urbanistFontFamily,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onPrimary
        ),

        countryItemBgShape = RoundedCornerShape(5.dp),
        showCountryFlag = true,
        showCountryCode = true,
        isEnabled = true,
        colors = ccpDefaultColors(
          //  primaryColor = redesignBackgroundColor,
            primaryColor = Color.White ,

            errorColor = MaterialTheme.colorScheme.error,

         //   backgroundColor = redesignBackgroundColor,
            backgroundColor = Color.White,

            surfaceColor = MaterialTheme.colorScheme.outlineVariant,

            outlineColor = MaterialTheme.colorScheme.outlineVariant,

            disabledOutlineColor = MaterialTheme.colorScheme.outline.copy(0.1f),

            unfocusedOutlineColor = MaterialTheme.colorScheme.onBackground.copy(0.3f),

            textColor = Color.White,

            cursorColor = MaterialTheme.colorScheme.primary,

            topAppBarColor = MaterialTheme.colorScheme.outlineVariant,

            countryItemBgColor = MaterialTheme.colorScheme.outlineVariant,

          //  searchFieldBgColor = redesignBackgroundColor,
            searchFieldBgColor = Color.White ,

            dialogNavIconColor = Color.White,

            dropDownIconTint = Color.White
        ),

        dialogcountrycodetextstyle = MaterialTheme.typography.labelSmall.copy(
            fontWeight = FontWeight.Normal,
         //   fontFamily = urbanistFontFamily,
            fontFamily = FontFamily.Cursive,
            fontSize = 14.sp,
            color = Color.White
        ),
    )
}

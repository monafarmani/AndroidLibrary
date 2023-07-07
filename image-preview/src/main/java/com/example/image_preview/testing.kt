package com.example.image_preview

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simon.xmaterialccp.data.utils.getDefaultLangCode
import com.simon.xmaterialccp.data.utils.getDefaultPhoneCode

@Composable
fun MainComponent(
    modifier: Modifier= Modifier,
    isLoading: Boolean,
    //context: Context = LocalContext.current,
    onClick: (countryLang: String, phoneCode: String, mobileNumber: String) -> Unit,
){

    val context = LocalContext.current
    LoginFields(
        modifier = modifier ,
        isLoading = isLoading,
        defaultPhoneCode =  getDefaultPhoneCode(context),
        defaultLangCode = getDefaultLangCode(context),
        onClick = onClick )
}

@Composable
fun LoginFields(
    modifier: Modifier,
    isLoading: Boolean,
    defaultPhoneCode: String,
    defaultLangCode: String,
    onClick: (countryLang: String, phoneCode: String, mobileNumber: String) -> Unit,
) {

    val phoneCode = remember {
        mutableStateOf(defaultPhoneCode)
    }

    val defaultLang = rememberSaveable {
        mutableStateOf(defaultLangCode)
    }

    val phoneNumber = remember {
        mutableStateOf("")
    }


    val isValidPhone = remember {
        mutableStateOf(true)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()){
        Column(
            modifier = modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CountryCodePickerItem(
                phoneCode = phoneCode,
                phoneNumber = phoneNumber,
                defaultLang = defaultLang,
                isValidPhone = isValidPhone,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

//        GizoFilledLoadingButton(
//            onClick = {
////                onClick(defaultLang.value, phoneCode.value, phoneNumber.value)
////            },
//            shape = 14.dp,
//            enabled = !isLoading,
//            isLoading = isLoading,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(60.dp),
//            text = {
//                Text(
//                    text = stringResource(id = R.string.sign_in),
//                    style = MaterialTheme.typography.labelSmall.copy(
//                        fontWeight = FontWeight.Bold,
//                        fontFamily = urbanistFontFamily,
//                        fontSize = 17.sp
//                    ),
//                    color = Color.White,
//                )
//            }
//        )
        
        Button(
            onClick = {
                onClick(defaultLang.value, phoneCode.value, phoneNumber.value)
            }
        ) {
            Text(text = "Sign In")
        }
        Spacer(modifier = modifier.height(34.dp))
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MainComponentPreview(modifier: Modifier = Modifier){
    MainComponent(
        modifier= modifier ,
        isLoading = false,
        //context = LocalContext.current ,
    onClick = {_ , _ , _ ->}
    )
}
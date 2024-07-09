package ru.netology

const val DAY_LIMIT = 150_000
const val MONTH_LIMIT = 600_000
const val ONE_LIMIT_VK = 15_000
const val MONTH_LIMIT_VK = 40_000
const val MONTH_LIMIT_MAESTRO = 75_000
const val RATE_MAESTRO = 0.006
const val MIN_COMISSION_VISA = 35
const val RATE_VISA = 0.0075

const val ERROR_TYPECARD = -1
const val ERROR_DAY_LIMIT = -2
const val ERROR_MONTH_LIMIT = -3
const val ERROR_ONE_LIMIT_VK = -4
const val ERROR_MONTH_LIMIT_VK = -5

fun comission(typeCard: String, thisTransfer: Int, previosTransfer: Int): Int {

    if(thisTransfer + previosTransfer > MONTH_LIMIT) {
        return ERROR_MONTH_LIMIT
    } else if(thisTransfer > DAY_LIMIT) {
        return ERROR_DAY_LIMIT
    }

    return when(typeCard) {
        "MasterCard" -> if(thisTransfer + previosTransfer <= MONTH_LIMIT_MAESTRO) 0 else (((thisTransfer + previosTransfer - MONTH_LIMIT_MAESTRO) * RATE_MAESTRO) + 20).toInt()
        "Maestro" -> if(thisTransfer + previosTransfer <= MONTH_LIMIT_MAESTRO) 0 else (((thisTransfer + previosTransfer - MONTH_LIMIT_MAESTRO) * RATE_MAESTRO) + 20).toInt()
        "Visa" -> if(thisTransfer * RATE_VISA <= MIN_COMISSION_VISA) MIN_COMISSION_VISA else (thisTransfer * RATE_VISA).toInt()
        "Мир" -> if(thisTransfer * RATE_VISA <= MIN_COMISSION_VISA) MIN_COMISSION_VISA else (thisTransfer * RATE_VISA).toInt()
        "VkPay" -> if(thisTransfer + previosTransfer > MONTH_LIMIT_VK) {
            ERROR_MONTH_LIMIT_VK
        } else if(thisTransfer > ONE_LIMIT_VK) {
            ERROR_ONE_LIMIT_VK
        } else {
            0
        }
        else -> ERROR_TYPECARD
    }
}
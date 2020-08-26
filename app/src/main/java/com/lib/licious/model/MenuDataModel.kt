package com.lib.licious.model

data class MenuDataModel(val imageUrl: String?, val name: String?, val weight: String?, val price: Double?, val maxCount: Int?, var count: Int = 0)
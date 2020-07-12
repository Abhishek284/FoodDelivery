import com.google.gson.annotations.SerializedName

data class LiciousDataResposne(
    @SerializedName("statusCode")
    val statusCode: Int?,
    @SerializedName("statusMessage")
    val statusMessage: String?,
    @SerializedName("data")
    val `data`: Data?
)

data class Data(
    @SerializedName("title")
    val title: String?,
    @SerializedName("filters")
    val filters: List<Filter>?,
    @SerializedName("info_message")
    val infoMessage: String?,
    @SerializedName("info_badge")
    val infoBadge: String?,
    @SerializedName("products")
    val products: List<Product>?
)

data class Filter(
    @SerializedName("type")
    val type: String,
    @SerializedName("title")
    val title: String
)

data class Product(
    @SerializedName("product_master")
    val productMaster: ProductMaster?,
    @SerializedName("product_merchantdising")
    val productMerchantdising: ProductMerchantdising?,
    @SerializedName("product_pricing")
    val productPricing: ProductPricing?,
    @SerializedName("product_inventory")
    val productInventory: ProductInventory?
)

data class ProductMaster(
    @SerializedName("pr_name")
    val prName: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("pr_weight")
    val prWeight: String?,
    @SerializedName("gross")
    val gross: Any?,
    @SerializedName("net")
    val net: Any?,
    @SerializedName("uom")
    val uom: String?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("hsn_no")
    val hsnNo: Int?,
    @SerializedName("created_at")
    val createdAt: Any?,
    @SerializedName("updated_at")
    val updatedAt: Any?,
    @SerializedName("product_id")
    val productId: String?,
    @SerializedName("pieces")
    val pieces: Any?,
    @SerializedName("text")
    val text: String?
)

data class ProductMerchantdising(
    @SerializedName("product_id")
    val productId: String?,
    @SerializedName("hub_id")
    val hubId: Int?,
    @SerializedName("city_id")
    val cityId: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("short_description")
    val shortDescription: String?,
    @SerializedName("meta_title")
    val metaTitle: String?,
    @SerializedName("meta_description")
    val metaDescription: String?,
    @SerializedName("meta_keywords")
    val metaKeywords: String?,
    @SerializedName("pr_image")
    val prImage: String?,
    @SerializedName("pr_image_bucket")
    val prImageBucket: String?,
    @SerializedName("pr_tags")
    val prTags: String?,
    @SerializedName("usp_desc")
    val uspDesc: String?,
    @SerializedName("msite_desc")
    val msiteDesc: String?,
    @SerializedName("wt_msg")
    val wtMsg: Any?,
    @SerializedName("product_delivery_type")
    val productDeliveryType: String?,
    @SerializedName("merchandise_name")
    val merchandiseName: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("cut_off_time")
    val cutOffTime: Int?,
    @SerializedName("slider_images")
    val sliderImages: String?,
    @SerializedName("product_shortname")
    val productShortname: String?,
    @SerializedName("no_of_piceces")
    val noOfPiceces: Any?,
    @SerializedName("serves")
    val serves: Any?,
    @SerializedName("cooking_time")
    val cookingTime: String?,
    @SerializedName("best_before")
    val bestBefore: String?,
    @SerializedName("product_header_tags")
    val productHeaderTags: String?,
    @SerializedName("pdp_gross_wt")
    val pdpGrossWt: Any?,
    @SerializedName("pdp_net_wt")
    val pdpNetWt: Any?,
    @SerializedName("pdp_pieces_img_url")
    val pdpPiecesImgUrl: String?,
    @SerializedName("pdp_serves_img_url")
    val pdpServesImgUrl: String?,
    @SerializedName("pdp_cooktime_img_url")
    val pdpCooktimeImgUrl: String?,
    @SerializedName("pdp_bestbefore_img_url")
    val pdpBestbeforeImgUrl: String?,
    @SerializedName("gross_wt_img_pdp")
    val grossWtImgPdp: String?,
    @SerializedName("net_wt_img_pdp")
    val netWtImgPdp: String?,
    @SerializedName("display_order")
    val displayOrder: Int?,
    @SerializedName("created_at")
    val createdAt: Any?,
    @SerializedName("updated_at")
    val updatedAt: Any?,
    @SerializedName("score")
    val score: Int?,
    @SerializedName("inv_sort")
    val invSort: Int?,
    @SerializedName("count_sort")
    val countSort: Int?,
    @SerializedName("recommended")
    val recommended: Boolean?
)

data class ProductPricing(
    @SerializedName("product_id")
    val productId: String?,
    @SerializedName("city_id")
    val cityId: Int?,
    @SerializedName("hub_id")
    val hubId: Int?,
    @SerializedName("base_price")
    val basePrice: Double?,
    @SerializedName("price_gram")
    val priceGram: Double?,
    @SerializedName("unit_gram")
    val unitGram: Double?,
    @SerializedName("cgst")
    val cgst: Double?,
    @SerializedName("sgst")
    val sgst: Double?,
    @SerializedName("created_at")
    val createdAt: Any?,
    @SerializedName("updated_at")
    val updatedAt: Any?
)

data class ProductInventory(
    @SerializedName("product_id")
    val productId: String?,
    @SerializedName("hub_id")
    val hubId: Int?,
    @SerializedName("cat_id")
    val catId: Int?,
    @SerializedName("stock_units")
    val stockUnits: Int?,
    @SerializedName("stock_lock")
    val stockLock: Int?,
    @SerializedName("merchant_delta")
    val merchantDelta: Int?,
    @SerializedName("created_at")
    val createdAt: Any?,
    @SerializedName("updated_at")
    val updatedAt: Any?,
    @SerializedName("dispatched_quantity")
    val dispatchedQuantity: Int?,
    @SerializedName("rm_buffer")
    val rmBuffer: Int?
)

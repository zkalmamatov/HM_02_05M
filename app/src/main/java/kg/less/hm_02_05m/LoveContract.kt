package kg.less.hm_02_05m

interface LoveContract {
    fun showResult(result: LoveModel)
    fun showError(message: String)
    fun getPercentage(firstName: String, secondName: String)
}
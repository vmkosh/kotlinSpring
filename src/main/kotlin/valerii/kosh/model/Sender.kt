package valerii.kosh.model

class Sender (
        var id: Int = 0,
        var code: String = "",
        private var props: MutableList<Prop> = mutableListOf<Prop>()
) {


    val properties: Map<String, String>
        get() {
            val map = mutableMapOf<String, String>()
            if (props.isNotEmpty()) {
                for (prop in props) {
                    map[prop.name] = prop.value
                }
            }
            return map
        }
}
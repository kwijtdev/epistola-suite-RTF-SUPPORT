package app.epistola.suite.documents

import tools.jackson.databind.JsonNode
import tools.jackson.databind.node.ObjectNode

object GenerationInputDataMerger {
    fun merge(data: ObjectNode, richContent: ObjectNode?): ObjectNode {
        val merged = data.deepCopy()
        if (richContent == null || richContent.isEmpty) {
            return merged
        }

        val fieldNames = richContent.fieldNames().asSequence().toList()
        for (name in fieldNames) {
            val value = richContent[name]
            if (value != null && !value.isNull) {
                merged.set<JsonNode>(name, value.deepCopy())
            }
        }

        return merged
    }
}

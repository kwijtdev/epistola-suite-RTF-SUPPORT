package app.epistola.suite.documents

import tools.jackson.databind.node.ObjectNode

object GenerationInputDataMerger {
    fun merge(data: ObjectNode, richContent: ObjectNode?): ObjectNode {
        val merged = data.deepCopy()

        if (richContent == null || richContent.isEmpty) {
            return merged
        }

        richContent.properties().forEach { (name, value) ->
            if (!value.isNull) {
                merged.set(name, value.deepCopy())
            }
        }

        return merged
    }
}
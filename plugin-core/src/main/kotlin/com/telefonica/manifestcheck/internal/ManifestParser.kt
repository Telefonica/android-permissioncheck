package com.telefonica.manifestcheck.internal

import com.telefonica.manifestcheck.internal.data.BasePermission
import com.telefonica.manifestcheck.internal.data.Feature
import com.telefonica.manifestcheck.internal.data.Permission
import com.telefonica.manifestcheck.internal.data.Sdk23Permission
import com.telefonica.manifestcheck.internal.util.createDocumentBuilder
import com.telefonica.manifestcheck.internal.util.forEach
import org.w3c.dom.Document
import java.io.File

internal class ManifestParser {
    private val namespace = "http://schemas.android.com/apk/res/android"

    fun parsePermissions(manifest: File): Set<BasePermission> {
        val permissions = mutableSetOf<BasePermission>()
        val document = createDocumentBuilder().parse(manifest)

        // Parse regular permissions
        permissions += parseNodes(document, "uses-permission").map { node ->
            Permission(node.name, node.maxSdkVersion)
        }

        // Parse SDK 23 permissions
        permissions += parseNodes(document, "uses-permission-sdk-23").map { node ->
            Sdk23Permission(node.name, node.maxSdkVersion)
        }

        // Parse features
        permissions += parseNodes(document, "uses-feature").map { node ->
            Feature(node.name, node.required, node.glEsVersion)
        }

        return permissions
    }

    private fun parseNodes(
        document: Document,
        tagName: String,
    ): Set<Node> {
        val nodes = mutableSetOf<Node>()
        val regularPermissions = document.getElementsByTagName(tagName)
        regularPermissions.forEach { element ->
            val name = element.getAttributeNS(namespace, "name")
            val maxSdkVersion = element.getAttributeNS(namespace, "maxSdkVersion").toIntOrNull()
            val required = element.getAttributeNS(namespace, "required").toBooleanStrictOrNull()
            val glEsVersion = element.getAttributeNS(namespace, "glEsVersion").takeIf { it.isNotEmpty() }
            nodes += Node(name, maxSdkVersion, required, glEsVersion)
        }
        return nodes.toSet()
    }

    data class Node(val name: String, val maxSdkVersion: Int?, val required: Boolean?, val glEsVersion: String?)
}

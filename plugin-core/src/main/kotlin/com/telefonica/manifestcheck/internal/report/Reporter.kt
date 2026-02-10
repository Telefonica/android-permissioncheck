package com.telefonica.manifestcheck.internal.report

import com.telefonica.manifestcheck.internal.data.Violation

internal interface Reporter {
    fun report(violations: Map<String, List<Violation>>)
}

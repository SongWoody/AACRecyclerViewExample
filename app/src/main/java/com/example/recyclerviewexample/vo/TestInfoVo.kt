package com.example.recyclerviewexample.vo

data class TestInfoVo(val name: String, val phone: String) {
    override fun equals(other: Any?): Boolean =
        if (other is TestInfoVo) {
            this.hashCode() == other.hashCode()
        } else {
            false
        }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + phone.hashCode()
        return result
    }
}
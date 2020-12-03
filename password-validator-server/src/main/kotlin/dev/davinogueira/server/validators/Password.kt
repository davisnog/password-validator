package dev.davinogueira.server.validators

class Password (private val validators: Array<ValidatorStrategy>) {
    private fun invalidPasswords(value: String) : List<ValidatorStrategy> {
        return validators.filterNot { it.isValid(value) }
    }

    fun isValid(value: String) : Boolean {
        return invalidPasswords(value).isEmpty()
    }
}
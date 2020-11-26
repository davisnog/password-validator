package dev.davinogueira.password.validators

class Password {
    companion object {
        private val validators = ArrayList<Validator>()
    }

    fun addValidator(validator: Validator) : Password {
        validators.add(validator)
        return this
    }

    private fun invalidPasswords(value: String) : List<Validator> {
        return validators.filterNot { it.isValid(value) }
    }

    fun isValid(value: String) : Boolean {
        return invalidPasswords(value).isEmpty()
    }
}
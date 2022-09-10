package com.rdm.scholsm.core.usecases.command

import com.rdm.scholsm.core.usecases.Command

data class NewUserCommand(val name: String): Command<Unit>

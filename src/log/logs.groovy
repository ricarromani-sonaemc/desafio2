package logs

def log_succeed(message) {
    echo "SUCCEED: ${message}"
}

def log_error(message) {
    echo "ERROR: ${message}"
}

export this
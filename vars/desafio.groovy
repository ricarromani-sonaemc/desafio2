def call(String name) {

    pipeline {
        agent none
        stages {
            stage ('Example') {
                steps {
                    // log.info 'Starting' 
                    script { 
                        echo 'example'
                    }
                }
            }
        }
    }
}
def call(String name = 'human') {
    def gv
    def objYaml

    pipeline {
        agent any

        stages {

            stage("Testing readYaml") {
                steps {
                    script {
                        echo 'hellooooo'
                    }

                }
            }

        }
    }
}
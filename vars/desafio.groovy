def call(body) {
    pipeline {
        agent any
        stages {
            stage('readYaml') {
                steps {
                    script {
                        ymlObj = readYaml file: "./family.yaml" 
                        echo "${ymlObj}"
                        echo "${ymlObj.getClass()}"
                    }
                }
            }
        }
    }
} 

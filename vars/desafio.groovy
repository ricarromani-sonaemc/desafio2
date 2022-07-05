def call(body) {

    //def branch = env.BRANCH_NAME 
    def ymlObj

    pipeline {
        agent any
        stages {
            stage('Checkout SCM') {
                git branch: 'yaml'
            }
            stage('readYaml') {
                steps {
                        ymlObj = readYaml file: "yaml-families/family.yaml" 
                        echo "${ymlObj}"
                        echo "${ymlObj.getClass()}"
                }
            }
        }
    }
}


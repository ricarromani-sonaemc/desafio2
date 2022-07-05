def call(body) {

    //def branch = env.BRANCH_NAME 

    pipeline {
        agent any
        stages {
            stage('readYaml') {
                steps {
                        checkout yaml

                        ymlObj = readYaml file: "yaml-families/family.yaml" 
                        echo "${ymlObj}"
                        echo "${ymlObj.getClass()}"
                }
            }
        }
    }
}


import pipeline.Families
import pipeline.Family
import pipeline.Member




def call(body) {

    //def branch = env.BRANCH_NAME 
    def yamlObj

    //def member2 = new Member()

    pipeline {
        agent any
        stages {
            
            stage('init') {
                steps {          
                    script {
                        git branch: "yaml", credentialsId: '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', url: "https://github.com/ricarromani-sonaemc/desafio2.git"
                        
                        //sh "ls ${WORKSPACE}"
                        yamlObj = readYaml file: "${WORKSPACE}/yaml-families/family.yaml"
                        //yamlObj = readYaml file: "resources/member.yaml"
                        echo "${yamlObj}" 
                               
                    }   
                }
            }
            
            stage('convert yaml to object') {
                steps {
                    script {

                        Families families = new Families()

                        for (int i = 0; i < yamlObj.families.size(); i++) {
                            echo "${yamlObj.families[i]}"

                            families.family.add(yamlObj.families[i])
                            
                            
                            Family family = new Family()

                            for(int f = 0; f < yamlObj.families[i].family.size(); f++) {
                                echo "${yamlObj.families[i].family[f]}"

                            }
                        }
                    }
                }
            
            }
        }         
    }
}
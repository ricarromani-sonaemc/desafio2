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
                        
                        echo "numero de familias = ${yamlObj.families.size()}"
                        for (int i = 0; i < yamlObj.families.size(); i++) {

                            Family family = new Family()
                            families.family.add(family)

                            echo "A familia ${i} é constituida por ${yamlObj.families[i].family[0].members.size()} membros."
                            for(int f = 0; f < yamlObj.families[i].family[0].members.size(); f++) {
                                
                                echo "${yamlObj.families[i].family[0].members[f]}"

                                Member member = new Member()
                                member.firstName = yamlObj.families[i].family[0].members[f].firstName
                                member.lastName = yamlObj.families[i].family[0].members[f].lastName
                                member.job = yamlObj.families[i].family[0].members[f].job
                                member.age = yamlObj.families[i].family[0].members[f].age

                                families[i].family[0].members.add(member)

                                //"Olá, o meu nome é X, tenho Z anos e vim da cidade Y. A minha profissão é K."
                                echo "Olá, o meu nome é ${member.firstName} ${member.lastName} e tenho ${member.age} anos. A minha profissão é ${member.job}."
                            }
                        }
                    
                    }
                }         
            }
        }
    }
}
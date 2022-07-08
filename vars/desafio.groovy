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
                        def ver = []
                        flag = 0;
                                                
                        Families families = new Families()                        
                        
                        echo "numero de familias = ${yamlObj.families.size()}"
                        for (int i = 0; i < yamlObj.families.size(); i++) {

                            Family family = new Family()
                            family.name = yamlObj.families[i].family[0].name
                            families.family.add(family)

                            echo "A familia ${family.name} é constituida por ${yamlObj.families[i].family[0].members.size()} membros."

                            for(int f = 0; f < yamlObj.families[i].family[0].members.size(); f++) {

                                Member member = new Member()
                                member.firstName = yamlObj.families[i].family[0].members[f].firstName
                                member.lastName = yamlObj.families[i].family[0].members[f].lastName
                                member.job = yamlObj.families[i].family[0].members[f].job
                                member.age = yamlObj.families[i].family[0].members[f].age
                                //echo "${member}"
                                //families[i].family[0].members.add(member)
                               
                                if(family.name == member.lastName){
                                    ver[flag] = 1
                                }
                                else {
                                    ver[flag] = 0
                                }  
                                flag++

                                echo "Membro: ${yamlObj.families[i].family[0].members[f]}"
                                //echo "${families}"

                                echo "---------------------------------------------------------------------------------------------"
                            }
                        }
                        echo "${flag}"
                        for( int l =0; l < flag ; l++)
                            echo "Numero: ${ver[l]}"

                        sizee =0
                        for (int i = 0; i < yamlObj.families.size(); i++) { 
                            Family family = new Family()
                            family.name = yamlObj.families[i].family[0].name
                            families.family.add(family)

                            echo "A familia ${family.name} é constituida por ${yamlObj.families[i].family[0].members.size()} membros."
                            for(int f = 0; f < yamlObj.families[i].family[0].members.size(); f++) {

                                Member member = new Member()
                                member.firstName = yamlObj.families[i].family[0].members[f].firstName
                                member.lastName = yamlObj.families[i].family[0].members[f].lastName
                                member.job = yamlObj.families[i].family[0].members[f].job
                                member.age = yamlObj.families[i].family[0].members[f].age
                            
                                if( ver[sizee] == 1) {
                                    echo "A familia ${family.name} é constituida por ${yamlObj.families[i].family[0].members.size()} membros."
                                    echo "A familia tem o ${yamlObj.families[i].family[0].members[f]}"
                                }
                                else {
                                    echo "Nao pertence a familia ${family.name}, ele esta na familia ${member.lastName}"
                                }                                
                                sizee++;

                            }
                        }
                        //echo "${member.ToString()}"
                        //echo "${member.firstName}"
                        //echo "${member.lastName}"
                        //echo "${member.job}"
                    }
                }
            }
            
        }
    }         
}

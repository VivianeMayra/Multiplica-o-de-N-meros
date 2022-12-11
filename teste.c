#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node
{
    int data;
    struct Node* next;
};
   

struct Node *newNode(int data)
{
    struct Node *new_node = (struct Node *) malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->next = NULL;
    return new_node;
}
   

void push(struct Node** head_ref, int new_data)
{

    struct Node* new_node = newNode(new_data);
   

    new_node->next = (*head_ref);
   

    (*head_ref) = new_node;
}
   

long long multiplyTwoLists (struct Node* first,struct Node* second)
{
    long long N= 1000000007;
    long long num1 = 0, num2 = 0;
    while (first || second){
         
        if(first){
            num1 = ((num1)*10)%N + first->data;
            first = first->next;
        }
         
        if(second)
        {
            num2 = ((num2)*10)%N + second->data;
            second = second->next;
        }
         
    }
    return ((num1%N)*(num2%N))%N;
}
   

void printList(struct Node *node)
{
    while(node != NULL)
    {
        printf("%d",node->data);
        if(node->next)
            printf("->");
        node = node->next;
    }
    printf("\n");
}
   

int main() {

 
    struct Node* first = NULL;
    struct Node* second = NULL;

    char firstNumber[10000];
   
    char secondNumber[10000];
  
    printf("Digite seu primeiro valor: ");
    scanf("%s",firstNumber);

    printf("Digite seu segundo valor: ");
    scanf("%s",secondNumber);

    int lenghtOfFirstNumber =  strlen(firstNumber);
    int lenghtOfSecondNumber =  strlen(secondNumber);
    
    char *strrev(char *str){
        char c, *front, *back;

        if(!str || !*str)
            return str;
        for(front=str,back=str+strlen(str)-1;front < back;front++,back--){
            c=*front;*front=*back;*back=c;
        }
        return str;
    }

    strrev(firstNumber);
    strrev(secondNumber);

    for (int i = 0; i < lenghtOfFirstNumber; i++) {  
        int aux = firstNumber[i] - '0';
		push(&first, aux); 
	}

    for (int i = 0; i < lenghtOfSecondNumber; i++) {  
        int aux = secondNumber[i] - '0';
		push(&second, aux); 
	}
   
    printf("resultado: ");
    long long ans = multiplyTwoLists(first, second);
    printf("%lld",ans);
   
    return 0;
}
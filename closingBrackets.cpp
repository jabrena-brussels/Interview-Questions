#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool is_balanced(string in) {
	int n=in.length();
	vector<char> expected;
    bool ok;
    char closing;

	for(int i=0;i<n;i++)
	{
		if(in[i]=='{')
		{
			expected.push_back('}');
		}
		else if(in[i]=='[')
		{
			expected.push_back(']');
		}
		else if(in[i]=='(')
		{
			expected.push_back(')');
		}
        else //i have a closing bracket
        {
            closing=expected.back(); //retrieve first element pushed in the "expected" array
            expected.pop_back(); //remove it from the array, since there is no need to check it against it again
            if(in[i]==closing) //if the character i read from input is a closed bracket and equal to what i expect
            {
                ok=true;
            }
            else
            {
                ok=false;
                break;
            }
        }
	}
    if(expected.size()!=0)
    {
        return false;
    }
	return ok;
}

int main(){
    string expression;
    cin >> expression;
    bool answer = is_balanced(expression);
    if(answer)
        cout << "true\n";
    else cout << "false\n";
    return 0;
}

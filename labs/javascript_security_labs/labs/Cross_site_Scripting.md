# Cross_site_Scripting - XSS:
	
## Experiments:

    1. URL Attack
    2. Script tag Attack


* URL Attack in Cross_site_Scripting:

## Procedure:
  
1. Open the src/Cross_site_Scripting/URL_Attack/Unsecured/index.html file in the browser
2. Enter the value for File URL and Click Search.

        Input:
          input.txt

3. It redirects to new page with the given file url.
4. The page contains the contents of file.
  
        Attack Possibile Input:
          scripts - javascript:alert("You are hacked");
          Input contains script, it executes the script in the input.

          Output:
            If input,
                  file name ->Redirect to that file execution.
                  script ->Execution paused with script execution

### Prevention Procedure:

1. Open the src/Cross_site_Scripting/URL_Attack/Secured/index.html file in the browser
   
            Input:
              script - javascript:alert("You are hacked");
          Prevention:  
            If input has script it encoded to url.
          Output:
            If input,
                file name ->Redirect to that file execution.
                scripts ->File not found in new page.


2. Script tag Attack in Cross_site_Scripting:

* Procedure:
  
1. Open the src/Cross_site_Scripting/Script_tag_Attack/Unsecured/index.html file in the browser
2. Enter the value for comment field and Click Submit.

          Possible Inputs:
              Any values for comment

3. It displays the entered contents in the page.

              Attack Possibile inputs:
                  Tags:
                    <script>alert("You are hacked");</script>
                    <button class="button" onclick="alert('You are hacked');">Button</button>
                  If comment field contains script or other tags,It executes the tags.

* Output:

            If input,
              text ->The page contains the entered data.
              tags ->Results of the tags.

* Prevention Procedure:
* Open the src/Cross_site_Scripting/Script_tag_Attack/Secured/index.html file in the browser

          Inputs:
              Tags:
              <script>alert("You are hacked");</script>
              <button class="button" onclick="alert('You are hacked');">Button</button>

* Output:
   - It displays the entered contents in the page.


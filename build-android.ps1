Write-Host "Android build helper: will try to run Gradle assembleDebug"

if (-not (Test-Path -Path "$PSScriptRoot\gradlew.bat")) {
    Write-Host "gradlew.bat not found. Attempting to run system 'gradle'..."
    $gradleCmd = "gradle"
} else {
    $gradleCmd = Join-Path $PSScriptRoot 'gradlew.bat'
}

Write-Host "Running: $gradleCmd assembleDebug"
& $gradleCmd assembleDebug
if ($LASTEXITCODE -ne 0) { Write-Host "Gradle build failed (exit $LASTEXITCODE)"; exit $LASTEXITCODE }

Write-Host "Build finished. APK (if produced): app\build\outputs\apk\debug\app-debug.apk"

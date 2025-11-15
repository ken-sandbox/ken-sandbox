# AndroidAppSample — ビルド手順 (Windows)

このフォルダは最小の Android (Kotlin) アプリの雛形です。英語 (`values`)、日本語 (`values-ja`)、中国語 (`values-zh`) の `strings.xml` を用意しています。

必要なもの:
- Java JDK 17 以上
- Android SDK（コマンドラインツールまたは Android Studio）
- Gradle（または `gradle wrapper` を生成）

推奨手順（PowerShell）:

1) SDK と JDK を準備し、環境変数を設定（例）:

```powershell
# 例: Android SDK パスを設定
$env:ANDROID_SDK_ROOT = 'C:\Users\<you>\AppData\Local\Android\Sdk'
# JDK が PATH に含まれていること（java / javac が使える）
```

2) Gradle wrapper を使う（推奨）。システムに gradle がない場合は、プロジェクトルートで次を実行して wrapper を生成してください（要 gradle）：

```powershell
# 1回だけ（ローカルで gradle が使える場合）
gradle wrapper
```

3) ビルド（`android-app` ディレクトリで）:

```powershell
Set-Location 'C:\Users\pyqjg\OneDrive\デスクトップ\app_dev\android-app'
# もし gradlew.bat があるなら
.\gradlew.bat assembleDebug
# あるいはシステムの gradle を使う場合
gradle assembleDebug
```

注意: このワークスペースには Gradle wrapper の実行ファイル（`gradlew`/`gradlew.bat` と `gradle/wrapper/gradle-wrapper.jar`）は含めていません。ローカルで `gradle wrapper` を実行するか、システムの Gradle をお使いください。

デバッグ APK は `app\build\outputs\apk\debug\app-debug.apk` に生成されます。

端末での言語切替や端末のロケール設定に応じてアプリは `strings.xml` から適切な翻訳を表示します。エミュレータや実機の言語を日本語/中国語に切り替えて動作確認してください。

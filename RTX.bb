Global moviefile2$ = "GFX\offline.avi"
Global VictimDead$ = "False" 
Global CoffinDoorOpen$ = "False"
Global CoffinCamera$ = "False"
Global IntroFinished$ = "NotSet"
Global Room2slDoorOpen$ = "False"
Global Room2slCanChange$ = "False"
Global LockroomCanChange$ = "False"
Global LampDemonState$ = "0"
Global lockroom173active$ = "False"

Global IzumiKatoTex
Global IzumiKato$ = "False"
Global Loaded173Model$ = "Inward3D"
Global Intro173Over$ = "NA"

Function UpdateSecurityCamsRTX()
    If PlayerRoom\RoomTemplate\Name$ = "start" Then
        LockroomCanChange$ = "False"
        MonitorStartChange()
    ElseIf PlayerRoom\RoomTemplate\Name$ = "room106" Then
        LockroomCanChange$ = "False"
        MonitorFemurBreakerChange()
    ElseIf PlayerRoom\RoomTemplate\Name$ = "room2sl" Then
        If Room2slCanChange$ = "True" Then 
            LockroomCanChange$ = "False"
            MonitorRoom2slChange()
        EndIf
    ElseIf PlayerRoom\RoomTemplate\Name$ = "room205" Then
        LockroomCanChange$ = "False"
        MonitorRoom205Change()
    ElseIf PlayerRoom\RoomTemplate\Name$ = "173" Then
        LockroomCanChange$ = "False"
        Monitor173Change()
    ElseIf PlayerRoom\RoomTemplate\Name$ = "Coffin" Or CoffinCamera$ = "True" Then
        LockroomCanChange$ = "False"
        MonitorCoffinChange()
    ElseIf PlayerZone <> 1 And PlayerRoom\RoomTemplate\Name$ <> "173" And PlayerRoom <> Null Then ;and PlayerRoom\RoomTemplate\Name <> "room2sl" And PlayerRoom\RoomTemplate\Name <> "173" And PlayerRoom\RoomTemplate\Name <> "start" And PlayerRoom\RoomTemplate\Name <> "coffin" And PlayerRoom\RoomTemplate\Name <> "room106" And CoffinCamera$ <> "False" Then
        LockroomCanChange$ = "True"
        MonitorLockroomChange()
    Endif
End Function

Function MonitorLockroomChange()
    If Room2slCanChange$ = "False" Then 
        If lockroom173active$ = "False" Then
            If moviefile2$ <> "GFX\LRLoop1.avi" Then
                moviefile2$ = "GFX\LRLoop1.avi"
                ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
                ;BlitzMovie_Play
            EndIf 
        ElseIf lockroom173active$ = "True" Then
            If moviefile2$ <> "GFX\LRLoop2.avi" Then
                moviefile2$ = "GFX\LRLoop2.avi"
                ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
                ;BlitzMovie_Play
            EndIf 
        EndIf 
    EndIf 
End Function

Function Monitor173Change()
    If moviefile2$ <> "GFX\PBLoop.avi" Then
        moviefile2$ = "GFX\PBLoop.avi"
        ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
        ;BlitzMovie_Play
    EndIf 
End Function

Function MonitorRoom2slChange()
    If Room2slDoorOpen$ = "False" Then
        If moviefile2$ <> "GFX\SLLoop1.avi" Then
            moviefile2$ = "GFX\SLLoop1.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf Room2slDoorOpen$ = "True"  Then
        If moviefile2$ <> "GFX\SLLoop2.avi" Then
            moviefile2$ = "GFX\SLLoop2.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf Room2slDoorOpen$ = "He's Coming"  Then
        If moviefile2$ <> "GFX\SLScene1.avi" Then
            moviefile2$ = "GFX\SLScene1.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf Room2slDoorOpen$ = "He's Come"  Then
        If moviefile2$ <> "GFX\SLScene2.avi" Then
            moviefile2$ = "GFX\SLScene2.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf Room2slDoorOpen$ = "He's Going Left"  Then
        If moviefile2$ <> "GFX\SLScene3Left.avi" Then
            moviefile2$ = "GFX\SLScene3Left.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf Room2slDoorOpen$ = "He's Going Right"  Then
        If moviefile2$ <> "GFX\SLScene3Right.avi" Then
            moviefile2$ = "GFX\SLScene3Right.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    EndIf
End Function

Function MonitorStartChange()
    If IntroFinished$ = "True" Then
        If moviefile2$ <> "GFX\ABLoop2.avi" Then
            moviefile2$ = "GFX\ABLoop2.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf
    ElseIf IntroFinished$ = "False" Then
        If moviefile2$ <> "GFX\ABLoop1.avi" Then
            moviefile2$ = "GFX\ABLoop1.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf
    EndIf
End Function

Function MonitorCoffinChange()
    If CoffinDoorOpen$ = "True" Then
        If moviefile2$ <> "GFX\895Open.avi" Then
            moviefile2$ = "GFX\895Open.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf
    Else
        If moviefile2$ <> "GFX\895Closed.avi" Then
            moviefile2$ = "GFX\895Closed.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf
    EndIf
End Function

Function MonitorRoom205Change()
    If LampDemonState$ = "0" Then
        If moviefile2$ <> "GFX\LDLoop1.avi" Then
            moviefile2$ = "GFX\LDLoop1.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, LampDemonsTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf LampDemonState$ = "1" Then
        If moviefile2$ <> "GFX\LDScene1.avi" Then
            moviefile2$ = "GFX\LDScene1.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, LampDemonsTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf LampDemonState$ = "2" Then
        If moviefile2$ <> "GFX\LDScene2.avi" Then
            moviefile2$ = "GFX\LDScene2.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, LampDemonsTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf LampDemonState$ = "3" Then
        If moviefile2$ <> "GFX\LDScene3.avi" Then
            moviefile2$ = "GFX\LDScene3.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, LampDemonsTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf LampDemonState$ = "4" Then
        If moviefile2$ <> "GFX\LDScene4.avi" Then
            moviefile2$ = "GFX\LDScene4.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, LampDemonsTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf LampDemonState$ = "5" Then
        If moviefile2$ <> "GFX\LDScene5.avi" Then
            moviefile2$ = "GFX\LDScene5.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, LampDemonsTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf LampDemonState$ = "6" Then
        If moviefile2$ <> "GFX\LDScene6.avi" Then
            moviefile2$ = "GFX\LDScene6.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, LampDemonsTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf LampDemonState$ = "7" Then
        If moviefile2$ <> "GFX\LDLoop2.avi" Then
            moviefile2$ = "GFX\LDLoop2.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, LampDemonsTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf LampDemonState$ = "8" Then
        If moviefile2$ <> "GFX\LDScene7.avi" Then
            moviefile2$ = "GFX\LDScene7.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, LampDemonsTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    EndIf
End Function

Function MonitorFemurBreakerChange()
    If VictimDead$ = "False"
        If moviefile2$ <> "GFX\FBLoop1.avi" Then
            moviefile2$ = "GFX\FBLoop1.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    ElseIf VictimDead$ = "True" Then 
        If moviefile2$ <> "GFX\FBLoop2.avi" Then
            moviefile2$ = "GFX\FBLoop2.avi"
            ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
            ;BlitzMovie_Play
        EndIf 
    EndIF
End Function

Function MonitorOfflineChange()
    If moviefile2$ <> "GFX\offline.avi" Then
        moviefile2$ = "GFX\offline.avi"
        ;BlitzMovie_OpenDecodeToTexture(moviefile2$, CCTVTexture, 1)
        ;BlitzMovie_Play
    EndIf 
End Function
